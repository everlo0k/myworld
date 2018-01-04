package com.bigears.pattern.command.one;

import com.bigears.pattern.command.one.Command;

/**
 * Keypad
 *
 * @author shenyang
 */
public class Keypad {

    private Command playCommand;

    private Command rewindCommand;

    private Command stopCommand;

    public Keypad(Command playCommand, Command rewindCommand, Command stopCommand) {
        this.playCommand = playCommand;
        this.rewindCommand = rewindCommand;
        this.stopCommand = stopCommand;
    }

    public void play() {
        playCommand.execute();
    }

    public void rewind() {
        rewindCommand.execute();
    }

    public void stop() {
        stopCommand.execute();
    }

}
