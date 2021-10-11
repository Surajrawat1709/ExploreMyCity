package com.futureapp.exploremycity;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

import static com.futureapp.exploremycity.R.layout.activity_videos;

public class videos extends AppCompatActivity {
    PlayerView playerView;
    SimpleExoPlayer player;
    boolean playWhenReady = true;
    int currentWindow = 0;
    long playbackPosition = 0;

    @Override
    protected void onStart() {
        super.onStart();
        if (Util.SDK_INT>=24)
            initPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
    if(Util.SDK_INT>=24)
        releasePlayer();
    super.onStop();
    }

    private void releasePlayer() {
        if (player!=null){
            playWhenReady=player.getPlayWhenReady();
            playbackPosition=player.getContentPosition();
            currentWindow=player.getCurrentWindowIndex();
            player.release();
            player=null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
        if(Util.SDK_INT<24||player==null){
            initPlayer();
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        playerView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE|
                        PlayerView.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    @Override
    protected void onPause() {
        if(Util.SDK_INT<24)
            releasePlayer();

        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_videos);

        playerView = findViewById(R.id.video_view);
        initPlayer();
    }

    private void initPlayer() {
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);
        playYoutubeVideo("https://www.youtube.com/watch?v=7a5m4td9U2k");
    }

    private void playYoutubeVideo(String youtubeUrl) {
        new YouTubeExtractor(this) {

            @Override
            protected void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta videoMeta) {
                int videoTag = 137;
                int audioTag = 140;
                MediaSource audioSource = new ProgressiveMediaSource
                        .Factory(new DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(ytFiles.get(audioTag).getUrl()));
                MediaSource videoSource = new ProgressiveMediaSource
                        .Factory(new DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(ytFiles.get(videoTag).getUrl()));
                player.setMediaSource(new MergingMediaSource(
                    true,
                videoSource,
                audioSource),
                true

                );
                player.prepare();
                player.setPlayWhenReady(playWhenReady);
                player.seekTo(currentWindow,playbackPosition);
            }
            }.extract(youtubeUrl, false, true);
    }

}
