package com.bigears.pattern.command.two;

/**
 * Controller
 *
 * @author shenyang
 */
public class Controller {

    private Command command;

    public Controller(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
