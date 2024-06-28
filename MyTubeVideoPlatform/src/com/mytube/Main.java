package com.mytube;

public class Main {

    public static void main(String[] args) {
        Video video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("john@domain.com"));

        VideoProcessor processor = new VideoProcessor(new BasicVideoEncoder(),new SqlVideoDatabase(),new EmailService());
        processor.process(video);
    }
}
