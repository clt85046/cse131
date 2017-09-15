package imageprocessor;

import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.EtchedBorder;

import sedgewick.Picture;

public class TopPanel extends DraggablePictureLabelPanel {

	private transient Picture picture;
	private transient final DropTargetAdapter dta;
	private DoublyLinkedList picList = new DoublyLinkedList();
	private int index;
	private int numPicsAdded;

	public TopPanel(final GUI gui){
		numPicsAdded=0;
		this.setTransferHandler(new TransferHandler("icon"));
		this.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		this.setLayout(new GridLayout(1,5));
		dta = new DropTargetAdapter() {
			public void drop(DropTargetDropEvent dtde) {
				try {
					Transferable tr = dtde.getTransferable();
					if (tr.isDataFlavorSupported(GUI.topPanel)) {
						dtde.dropComplete(true);
					}
					else {
						picture = (Picture) tr.getTransferData(GUI.sedgewickPicture);
						addPicture( picture);
						dtde.dropComplete(true);
					}
				} catch (Exception e) {
					dtde.rejectDrop();
				}
			}
		};
		new DropTarget(
				this, 
				DnDConstants.ACTION_COPY, 
				dta,
				true, 
				null);
	}

	public DropTargetAdapter getDropTargetAdapter() {
		return this.dta;
	}

	public void addPicture(final File file) {
		System.out.println("Opening: " + file);
		addPicture(new Picture(file));
	}

	public void addPicture(final Picture picture) {
		final JLabel label = picture.getJLabel();
		new DropTarget(
				label, 
				DnDConstants.ACTION_COPY, 
				getDropTargetAdapter(),
				true, 
				null);
		label.addMouseListener(ma);
		label.setTransferHandler(genTH(label, picture, numPicsAdded));
		picList.add(new PicListItem(label, numPicsAdded));
		numPicsAdded++;
		if (picList.getSize() > 5)
			index = picList.getSize() - 5;
		showPics();
	}

	public void showPics() {
		int increment = 0;
		PicListItem iterable = picList.getHead().next;
		if (picList.getSize() > 5) {
			while (index != increment) {
				iterable = iterable.next;
				increment++;
			}
			removeAll();
			setVisible(false);
			for (int i = 0; i < 5; i++) {
				add(iterable.getJLabel(), i);
				iterable = iterable.next;
			}
			setVisible(true);
		} else {
			removeAll();
			setVisible(false);
			for (int i = 0; i < picList.getSize(); i++) {
				add(iterable.getJLabel(), i);
				iterable = iterable.next;
			}
			setVisible(true);
		}

	}

	public void removePicture(int ID) {
		picList.remove(picList.find(ID));
		showPics();
	}

	public void moveRight() {
		if (picList.getSize() < 5)
			return;
		if (index + 5 == picList.getSize())
			return;
		else {
			index++;
			showPics();
		}
	}

	public void moveLeft() {
		if (index == 0) {
			return;
		} else {
			index--;
			showPics();
		}
	}

	@Override
	public Object getTransferData(DataFlavor arg0)
			throws UnsupportedFlavorException {
		if (arg0 == GUI.topPanel) {
			System.out.println("gen top panel");
			return this;
		} else
			throw new UnsupportedFlavorException(arg0);
	}

	@Override
	public DataFlavor getTransferDataFlavor() {
		return GUI.topPanel;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor df) {
		return df == GUI.topPanel;
	}


}

