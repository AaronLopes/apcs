package essentials;

public class LoudDog extends Dog{

	public LoudDog(String name)
	{
		super(name);
	}
	
	public String speak()
	{
		String loudDogSound = super.speak();
		return loudDogSound + loudDogSound;
	}
}
