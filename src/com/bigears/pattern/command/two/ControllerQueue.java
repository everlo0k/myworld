package com.bigears.pattern.command.two;

/**
 * ControllerQueue
 *
 * @author shenyang
 */
public class ControllerQueue {

    private CommandQueue commandQueue;

    public ControllerQueue(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void execute() {
        commandQueue.execute();
    }
}
