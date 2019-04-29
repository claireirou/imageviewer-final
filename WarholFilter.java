import java.awt.Color;

/**
 * An image filter to show a Warhol inspired version of the image.
 *
 * @author Claire Iroudayassamy
 * @version 2019.04.29
 */
public class WarholFilter extends Filter
{
    
    private OFImage original;
    private OFImage quadrant1;
    private OFImage quadrant2;
    private OFImage quadrant3;
    private OFImage quadrant4;
    private int width;
    private int height;
    private RedChannelFilter redChannel;
    private GreenChannelFilter greenChannel;
    private BlueChannelFilter blueChannel;
    
    /**
     * Constructor for objects of class WarholFilter
     * @param name The name of the filter
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image
     * 
     * @param image The image to be changed by this filter
     */
    public void apply(OFImage image)
    {
        original = new OFImage(image);
        width = original.getWidth();
        height = original.getHeight();
        
        quadrant1 = resize(image);
        quadrant2 = resize(image);
        quadrant3 = resize(image);
        quadrant4 = resize(image);
        
        redChannel.apply(quadrant1);
        greenChannel.apply(quadrant3);
        blueChannel.apply(quadrant4);
        
        
        
    }
     
    /**
     * Resize the image to 1/4 its original size.
     * 
     * @param image The image to be resized.
     */
    private OFImage resize(OFImage image)
    {
        int width = image.getWidth() / 4;
        int height = image.getHeight() / 4;
        OFImage newImage = new OFImage(width, height);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                newImage.setPixel(x, y, image.getPixel(x * 4, y * 4));
            }
        }
        
        return newImage;
    }
}
