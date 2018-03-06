import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class facebook {

	FacebookClient facebookClient = new DefaultFacebookClient("CAACEdEose0cBAMOCg6yZAxedd46ZCTwrxaEXXkvZBsNykSG3OlGsCrzvVIVwlJWzbufZBxR2ZBIjDRZBXE6uXvl98J8e6OJN7RQVZBrhdSHIMBvj2cERZCxXhZCwW8w2MLChohZBTIArxddAjgrxL731UviB3W3Eak48HVopNMWn4tQ5TZARDIYYCFsqM9RYrjc11kZD");

	private void getMyInformation(){
		User me = facebookClient.fetchObject("me", User.class);

		System.out.println(me.getName());
	}

	private void getMyFriends(){
		Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);

		System.out.println("Count of my friends: "+myFriends.getData().size());

		for(User friend : myFriends.getData()){
			System.out.println(friend.getName());
		}
	}

	public static void main(String[] args){
		facebook facebookInstance = new facebook();

		facebookInstance.getMyInformation();

		facebookInstance.getMyFriends();
	}


}