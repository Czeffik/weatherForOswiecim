public class WorkingProgram {
    private Long actualTime;
    private long time =1487354400;

    public WorkingProgram() throws InterruptedException {
        WritingMathToFile work = new WritingMathToFile();
        actualTime = (System.currentTimeMillis()/1000);
        this.working();

    }
    private void working() throws InterruptedException {

        if ((actualTime=actualTime-(actualTime%100)) == time){
            WritingMathToFile working = new WritingMathToFile();
            time+=10800;
            Thread.sleep((time-actualTime)*1000);
            actualTime = (System.currentTimeMillis()/1000);
            this.working();
        }
        else{
            actualTime = (System.currentTimeMillis()/1000);
            Thread.sleep((time-actualTime)*1000);
            this.working();
        }
    }
}

