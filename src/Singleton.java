class Singleton{
  public String str;
  private Singleton(){}
  public static Singleton instance;

  public static Singleton getSingleInstance(){
    if(instance == null) instance = new Singleton();
    return instance;
  }
}
