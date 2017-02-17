public class WorkingProgram {
    private Long actualTime;
    public WorkingProgram() throws InterruptedException {
        WritingMathToFile work = new WritingMathToFile();
        actualTime = (System.currentTimeMillis()/1000);
        this.working();
    }
    private void working() throws InterruptedException {

        if (actualTime == 1487354400){
            Thread.sleep(1000);
            WritingMathToFile working = new WritingMathToFile();
            actualTime+=10800;
        }
        else{
            Thread.sleep(1000);
            this.working();
        }
    }
}

