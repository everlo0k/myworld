package com.bigears.pattern.command.one;

/**
 * GodEverlook
 *
 * @author shenyang
 */
public class GodEverlook {

    private static Keypad keypad;
    private static AudioPlayer audioPlayer = new AudioPlayer();

    public static void test() {
        Command play = new PlayCommand(audioPlayer);
        Command rewind = new RewindCommand(audioPlayer);
        Command stop = new StopCommand(audioPlayer);
        keypad = new Keypad(play, rewind, stop);
        keypad.play();
        keypad.rewind();
        keypad.stop();
    }

    public static void main(String[] args) {
        test();
    }



}
