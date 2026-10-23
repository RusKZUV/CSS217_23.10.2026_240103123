package Task7;

public class AudioAdapter implements MediaPlayer {
    private AdvancedAudioPlayer advancedPlayer;

    public AudioAdapter(AdvancedAudioPlayer advancedPlayer) {
        this.advancedPlayer = advancedPlayer;
    }

    public void play(String format, String file) {
        if (format.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(file);
        } else if (format.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(file);
        } else {
            throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}