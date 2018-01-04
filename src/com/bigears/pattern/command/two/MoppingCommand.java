package com.bigears.pattern.command.two;

/**
 * MoppingCommand
 *
 * @author shenyang
 */
public class MoppingCommand implements Command{

    private MoppingRobbot moppingRobbot;

    public MoppingCommand() {
        this.moppingRobbot = new MoppingRobbot();
    }

    @Override
    public void execute() {
        moppingRobbot.mopping();
    }
}
