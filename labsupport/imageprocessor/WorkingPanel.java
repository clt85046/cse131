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

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import javax.swing.border.EtchedBorder;

import org.apache.commons.math.util.MathUtils;

import sedgewick.Picture;

public class WorkingPanel extends DraggablePictureLabelPanel {

	private static final long serialVersionUID = 1L;
	public transient Picture picture;
	private transient final DropTargetAdapter dta;
	private JLabel label;
	private final int num;

	public WorkingPanel(int num) {
		this.num = num;
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(new GridLayout(1, 1, 0, 0));
		this.dta = genDTA("panel");

		new DropTarget(this, DnDConstants.ACTION_COPY, dta, true, null);
	}

	public int getNum() {
		return num;
	}
	
	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture pic) {
		this.picture = pic;
		this.setVisible(false);
		this.removeAll();
		this.label = pic.getJLabel();

		new DropTarget(label, DnDConstants.ACTION_COPY, genDTA("label"), true, null);

		this.add(label);
		label.addMouseListener(ma);
		label.setTransferHandler(genTH(label, pic, Integer.MIN_VALUE));
		this.setVisible(true);

	}
	
	public void clearpicture() {
		this.setVisible(false);
		this.removeAll();
		this.setVisible(true);
		//setPicture(new Picture(100,100));
	}

	private DropTargetAdapter genDTA(final String message) {
		return new DropTargetAdapter() {
			public void drop(DropTargetDropEvent dtde) {
				try {
					//					System.out.println("Drop from " + message);
					Transferable tr = dtde.getTransferable();
					Picture picture = (Picture) tr.getTransferData(GUI.sedgewickPicture);
					setPicture(picture);
					dtde.dropComplete(true);
				} catch (Exception e) {
					dtde.rejectDrop();
				}
			}
		};

	}

	@Override
	public Object getTransferData(DataFlavor arg0) throws UnsupportedFlavorException {
		if (arg0 == GUI.workingPanel) {
			System.out.println("gen working panel");
			return this;
		} else
			throw new UnsupportedFlavorException(arg0);
	}

	@Override
	public DataFlavor getTransferDataFlavor() {
		return GUI.workingPanel;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		return arg0 == GUI.workingPanel;
	}



}
