


public class App{
   private Canvas canvas;
   
   private Map<String, Command> commandMap;
   private BasicDrawingTool drawingTool = new BasicDrawingTool();
   
   public App(){
      registerDefaultCommands();
   }
   
   
   public void execute(Stirng key, String... arugments){
      Command cmd = commandMap.get(key);
      if (cmd==null) throw ...;
      cmd.execute(this, arguments);
   }
   
   protected void registerDefaultCommands(){
       commandMap.put("R", new RedoCommand());
       commandMap.put("L", new DrawingCommand(DefaultImageModifiers.drawline(getDrawingTool()));
   }
      
   protected BasicDrawingTool getDrawingTool(){
      return drawingTool;
   }
   
   public static void main(){
      App app = new App();
      while (true){
         String line = //obtainNextLine;
         String key = //splitFromLine;
         String[] arguments = //from Line;
         if (key.equals("exit")){
          break;
         }
         app.execute(key, aruments):
         
      }
   
   
   }



}

 public class Canvas{
    public void undo();
    public void redo();
    public Image getImage();
    public void commit(); //add the current image to stack;
    public void rollback();//discard the current change;
 }
 public class Image{
    public void setPixel(...);
 }
 public class BasicDrawingTool{
    public void drawRectangel(Image img, int x1, int y1, int x2, int y2);
    public void drawLine(IMage img ...);
 }

 public interface Command{
    public void execute(App app, String[] arugments);
 }
 public class DrawingCommand implements Command{
    private IMageModifier imageModifier; //passed in as constructor

    public void execute(App app, String[] arguments){
        Canvas canvas = app.getCanvas();
        if (canvas==null) throw...;
        try{
          imageModifier.modify(canvas.getImage(), arguments);
        } catch (Exception e){
          canvas.rollback();
        }
        canvas.comit();
    }
 }

 public interface ImageModifier{
     public void modify(IMage img, arguments) throw InvalidArgumentExceptions;
 }
 public class RedoCommand implements Command {
 }
 public class DefaultImageModifiers {
 
     public IMageModifier drawLine(BasicDrawingTool drawingTool){
         return (img, arguments) -> {
             //get coordinates from arguement;
             drawingTool.drawLine(img, cooredinates);
         }
     
     }
 
 }
