package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private NotificationService notification;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService notification) {
        this.encoder = encoder;
        this.database = database;
        this.notification = notification;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notification.notify(video.getUser());
    }

}

