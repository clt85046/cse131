package imageprocessor;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TrashButton extends JButton {
	
	final private TopPanel topPanel;
	
	public TrashButton(String s, final TopPanel topPanel, final GUI gui) {
		super(s);
		this.topPanel = topPanel;
		new DropTarget(this, DnDConstants.ACTION_COPY,
				new DropTargetAdapter() {
			public void drop(DropTargetDropEvent dtde) {
				try {
					if (dtde.isDataFlavorSupported(GUI.workingPanel)) {
						WorkingPanel wp = (WorkingPanel)dtde.getTransferable().getTransferData(GUI.workingPanel);
						gui.getWorkingPanel(wp.getNum()).clearpicture();
					}
					else if (dtde.isDataFlavorSupported(GUI.topPanel)) {
						int ID= (Integer) dtde.getTransferable().getTransferData(GUI.ID);
						topPanel.removePicture(ID);
					}
					dtde.dropComplete(true);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
					dtde.rejectDrop();
				}
			}
		}, true, null);

	}

}
