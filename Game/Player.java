import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.BodyList;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.DynamicShape;

public class Player extends Body
{
	private World myWorld;
	private boolean movingLeft;
	private boolean movingRight;
	private boolean isUp = false;
	int points;
	
	
	
	public boolean isUp() 
	{
		this.setCanRest(true);
		BodyList list = this.getTouching();
		if (list.size() == 0)
			return false;
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("Object Touching: " + list.get(i));
			if (list.get(i).getName().equals("Floor"))
			{
				return false;
			}
		}
		return true;
	}

	
	public boolean isMovingLeft() {
		return movingLeft;
	}


	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}


	public boolean isMovingRight() {
		return movingRight;
	}


	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}


	


	public Player(DynamicShape shape, float m, String myName) 
	{
		super(myName, shape, m);
		setDamping(0);

		// TODO Auto-generated constructor stub
	}

	
	public void moveLeft()
	{
		setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(-75, 0));
		setVelocity(new Vector2f(-75, this.getVelocity().getY()));
	}

	public void moveRight()
	{

		setMaxVelocity(75.0f, 5000.0f);
		//adjustVelocity(new Vector2f(75, 0));
		setVelocity(new Vector2f(75f,this.getVelocity().getY()));
	}


	public void jump()
	{
		
			setMaxVelocity(75.0f, 5000.0f);
			adjustVelocity(new Vector2f(0, -100));
			isUp = true;
	}


	public void stop()
	{
		this.setVelocity(new Vector2f(0,0));
		
	}
	



}

