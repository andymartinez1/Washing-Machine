import java.util.ArrayList;
/*
 * Description
 * A lab for testing washing machines by operating their 
 * controls and printing the status of the machine 
 */

 public class WashingMachineTestLab {
    private StringBuilder line = new StringBuilder(); 
    private NoteBook noteBook = new NoteBook(); 

    public void RunTest() {
        // This list keeps track of washing machines delivered to lab
       ArrayList<WashingMachine> testWashers = new ArrayList<>(); 
       
       // Adding washing machines into the list 
       testWashers.add( new WashingMachine("washer1",2.0) );   
       testWashers.add( new WashingMachine("washer2",2.0) );   
       testWashers.add( new WashingMachine("washer3",3.0) );
       testWashers.add( new WashingMachine("washer4",3.0) );
       testWashers.add( new WashingMachine("washer5",3.0) );
       
       noteBook.LogStatus("Five washers delivered to lab", testWashers);
       
       for (WashingMachine w : testWashers) {
            w.AddClothes(2.0);      
        }
        
        noteBook.LogStatus("Added 2.0cf clothing", testWashers);
        
        for (WashingMachine w : testWashers) {
            w.AddSoap();
            w.StartWasher(); 
        } 
        
        noteBook.LogStatus("Added soap and Started", testWashers);
        
        for (WashingMachine w : testWashers) {
            w.StopWasher();
        }  
        
        noteBook.LogStatus("Test completed", testWashers);
        noteBook.Save(); 
  }
}

