package com.bigears.pattern.command.two;

/**
 * SweepCommand
 *
 * @author shenyang
 */
public class SweepCommand implements Command {

    private SweepRobbot sweepRobbot;

    public SweepCommand() {
        this.sweepRobbot = new SweepRobbot();
    }

    @Override
    public void execute() {
        sweepRobbot.sweep();
    }
}
