package com.guercifzone.hity2ube.Lib;

import java.util.ArrayList;

public interface OnVideoFoundListener {
    void onVideo(ArrayList<VideoLink> videos);
    void onError(String error);
}
