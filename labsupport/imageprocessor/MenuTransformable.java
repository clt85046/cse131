package imageprocessor;

import sedgewick.Picture;

public interface MenuTransformable {
	
	public String getMenuName();
	public void transform(Picture source1, Picture source2, Picture target);

}
