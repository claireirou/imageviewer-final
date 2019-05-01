import java.awt.Color;

/**
 * An image filter to show a Warhol inspired version of the image.
 * The image is split up into four quadrants each with a different
 * filter on it.
 *
 * @author Claire Iroudayassamy
 * @version 2019.04.29
 */
public class WarholFilter extends Filter
{
    private OFImage original;
    private OFImage newImage;
    private int newHeight;
    private int newWidth;
    
    /**
     * Constructor for objects of class WarholFilter
     * @param name The name of the filter
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param image The image to be changed by this filter
     */
    public void apply(OFImage image)
    {
        original = new OFImage(image);
        newWidth = original.getWidth() / 2;
        newHeight = original.getHeight() / 2;
        
        // Display quadrant I.
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                image.setPixel(x + newWidth, y, original.getPixel(x * 2, y * 2));
            }
        }
        
        // Display quadrant II.
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                image.setPixel(x, y, original.getPixel(x * 2, y * 2));
            }
        }
        
        // Display quadrant III.
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                image.setPixel(x, y + newHeight, original.getPixel(x * 2, y * 2));
            }
        }
        
        // Display quadrant IV.
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                image.setPixel(x + newWidth, y + newHeight, original.getPixel(x * 2, y * 2));
            }
        }
        
        
        // Set quadrant filters
        // Quadrant I Red Channel Filter
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                Color pix = image.getPixel(x, y);
                int redValue = pix.getRed();
                
                image.setPixel(x + newWidth, y, new Color(redValue, redValue, redValue));
            }
        }
        
        // Quadrant III Green Channel Filter
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                Color pix = image.getPixel(x, y);
                int greenValue = pix.getGreen();
                
                image.setPixel(x, y + newHeight, new Color(greenValue, greenValue, greenValue));
            }
        }
        
        // Quadrant IV Blue Channel Filter
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newWidth; x++) {
                Color pix = image.getPixel(x, y);
                int blueValue = pix.getBlue();
                
                image.setPixel(x + newWidth, y + newHeight, new Color(blueValue, blueValue, blueValue));
            }
        }
    }
}
