package com.mytube;

public class BasicVideoEncoder implements VideoEncoder {

    @Override
   public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }

}
