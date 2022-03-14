package drawing.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack<ICommand> undoStackCommand;
    private Stack<ICommand> redoStackCommand;

    public CommandHistory(){
        this.undoStackCommand = new Stack<>();
        this.redoStackCommand = new Stack<>();
    }

    public void exec(ICommand command){
        this.undoStackCommand.push(command);
        command.execute();
    }

    public void undo(){
        if(!undoStackCommand.empty()){
            ICommand command = undoStackCommand.pop();
            redoStackCommand.push(command);
            command.undo();
        }
        else{
            System.out.println("no more actions to undo");
        }
    }

    public void redo(){
        if(!redoStackCommand.empty()){
            ICommand command = redoStackCommand.pop();
            undoStackCommand.push(command);
            command.execute();
        }
        else{
            System.out.println("no more actions to redo");
        }
    }

    public boolean canUndo(){
        return undoStackCommand.empty();
    }

    public boolean canRedo(){
        return redoStackCommand.empty();
    }
}
