package utils;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class SVGImage extends JLabel {
    private FlatSVGIcon svgIcon;

    public void setSvgImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        this.setIcon(svgIcon);
    }
}
