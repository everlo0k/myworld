package com.bigears.pattern.command.two;

/**
 * GodEverlook
 *
 * @author shenyang
 */
public class GodEverlook {

    public static void main(String[] args) {

        // 单一命令
        MoppingCommand moppingCommand = new MoppingCommand();
        Controller controller = new Controller(moppingCommand);
        controller.execute();


        // 多个命令
        MoppingCommand moppingCommand2 = new MoppingCommand();
        SweepCommand sweepCommand = new SweepCommand();
        CommandQueue commandQueue = new CommandQueue();
        commandQueue.addCommand(moppingCommand2);
        commandQueue.addCommand(sweepCommand);
        ControllerQueue controllerQueue = new ControllerQueue(commandQueue);
        controllerQueue.execute();

    }

}
