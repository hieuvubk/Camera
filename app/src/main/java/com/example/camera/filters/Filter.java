package com.example.camera.filters;

public class Filter {
    public static final String NEGATIVE = "@curve R(0, 0)(97, 97)(255, 255)RGB(0, 125)(255, 0) @adjust whitebalance 1 0.8 ";

    public static final String FUJI_C200 = "@adjust colorbalance -0.1 0.02 -0.06 @adjust whitebalance 0.08 1.08 @adjust contrast 1.12 @adjust saturation 1.08 @curve RGB(0, 20)(63, 47)(255, 255) @adjust shadowhighlight 26 -23 @adjust colorbalance 0.02 -0.03 0.02 ";

    public static final String KODAK_COLORPLUS = "@adjust contrast 0.76 @adjust saturation 1.12 @adjust shadowhighlight -1 -17 @adjust hue 0.523599 @curve R(0, 0)(7, 7)(255, 255)G(0, 0)(98, 94)(255, 255)B(0, 0)(113, 111)(255, 255)RGB(0, 0)(9, 6)(117, 108)(255, 255) @pixblend hue 2 3 4 255 100  ";

    public static final String KODAK_PROIMAGE = "@adjust colorbalance -0.1 0.02 0.06 @adjust whitebalance 0.08 1.02 @adjust contrast 1.12 @adjust saturation 1.08 @curve RGB(0, 20)(63, 47)(255, 255) @adjust shadowhighlight 26 -23 @adjust colorbalance 0.05 0.03 0.02 ";
}
