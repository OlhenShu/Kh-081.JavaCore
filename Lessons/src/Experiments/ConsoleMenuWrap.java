package Experiments;
import java.util.Arrays;


public class ConsoleMenuWrap {
    private int consoleWidth;
    private String[] window;
    private int step=0;

    public ConsoleMenuWrap(int width) {
        consoleWidth = width;
        window = new String[1];
        StringBuilder topBuilder = new StringBuilder();
        for (int i=0; i<consoleWidth; i++){
            if(i==0 || i==consoleWidth-1){
                topBuilder.append("▣");
            }else{
                topBuilder.append("=");
            }
        }
        window[0] = topBuilder.toString();
        for (int i=1; i<window.length; i++){
            window[i] = " ";
        }
    }

    public ConsoleMenuWrap(){
        consoleWidth = 32;
        window = new String[1];
        StringBuilder topBuilder = new StringBuilder();
        for (int i=0; i<consoleWidth; i++){
            if(i==0 || i==consoleWidth-1){
                topBuilder.append("▣");
            }else{
                topBuilder.append("=");
            }
        }
        window[0] = topBuilder.toString();
        for (int i=1; i<window.length; i++){
            window[i] = " ";
        }
    }

    //Виводим нашу сторіночку;
    public void show(){
        step++;
        System.out.println("▣ Step: "+step);
        for (String line : this.window) {
            System.out.println(line);
        }
        System.out.println(" ");
    }

    //одаєм новий рядок
    public void addLine(String line){
        this.window  = Arrays.copyOf(this.window, this.window.length+1);
        this.window[this.window.length-1] = line;
        if(consoleWidth<this.window.length){
            consoleWidth = this.window.length;
        }
    }

    //Витираєм все зайве
    public void clear(){
        this.window  = Arrays.copyOf(this.window, 1);
    }

    public void delete(){
        //видаляє останній
        this.window  = Arrays.copyOf(this.window, this.window.length-1);
    }

    public void delete(int index){
        //видаляє за номером рядка
        String[] tempS = this.window;
        this.window = Arrays.copyOf(this.window, this.window.length-1);
        int i=1;
        int j=1;

        if (index!=1) {
            while (i < this.window.length) {
                if (i == index - 1) {
                    this.window[i] = tempS[j];
                    i++;
                    j += 2;
                } else {
                    this.window[i] = tempS[j];
                    i++;
                    j++;
                }
            }
        }
        else {
            j++;
            while (i < this.window.length){
                this.window[i] = tempS[j];
                i++;
                j++;
            }
        }
    }

    public int getConsoleWidth(){
        return consoleWidth;
    }

    public void setConsoleWidth(int consoleWidth){
        this.consoleWidth = consoleWidth;
        StringBuilder topBuilder = new StringBuilder();
        for (int i=0; i<consoleWidth; i++){
            if(i==0 || i==consoleWidth-1){
                topBuilder.append("▣");
            }else{
                topBuilder.append("=");
            }
        }
        window[0] = topBuilder.toString();
    }

    public String getLine(int Index){
        return window[Index+1];
    }

    public int getNumberOfLines(){
        return window.length -1;
    }
}