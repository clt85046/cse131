package imageprocessor;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import sedgewick.Picture;

public abstract class DraggablePictureLabelPanel extends JPanel {

	public DraggablePictureLabelPanel() {
		super();
	}

	protected transient MouseAdapter ma = new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			JComponent comp = (JComponent) e.getSource();
			TransferHandler th = comp.getTransferHandler();
			th.exportAsDrag(comp, e, TransferHandler.COPY);
		}
	};

	
	public abstract Object getTransferData(DataFlavor df) throws UnsupportedFlavorException;
	public abstract DataFlavor getTransferDataFlavor();
	public abstract boolean isDataFlavorSupported(DataFlavor df);

	protected TransferHandler genTH(final JLabel label, final Picture pic, final Integer ID) {
		return new TransferHandler() {
			private static final long serialVersionUID = 1L;

			public int getSourceActions(JComponent c) {
				return TransferHandler.COPY;
			}

			public Transferable createTransferable(JComponent c) {
				return new Transferable() {
					@Override
					public Object getTransferData(DataFlavor arg0)
							throws UnsupportedFlavorException, IOException {
						if (arg0.equals((GUI.sedgewickPicture))) {
							System.out.println("gen picture");
							return pic;
						} else if (arg0.equals(GUI.pictureLabel)) {
							System.out.println("gen label " + label);
							return label;
						}
						else if(arg0.equals(GUI.ID)){
							return ID;
						}
						else return DraggablePictureLabelPanel.this.getTransferData(arg0);
					}

					@Override
					public DataFlavor[] getTransferDataFlavors() {
						return new DataFlavor[] { DraggablePictureLabelPanel.this.getTransferDataFlavor(),
								GUI.pictureLabel,
								GUI.sedgewickPicture,
						};
					}

					@Override
					public boolean isDataFlavorSupported(DataFlavor arg0) {
						return 
								DraggablePictureLabelPanel.this.isDataFlavorSupported(arg0)
								|| arg0 == GUI.sedgewickPicture
								|| arg0 == GUI.pictureLabel;
					}

				};
			}

			public void exportDone(JComponent c, Transferable t, int action) {
			}
		};
	}

}