/**
 * 
 */
package com.techvisionworks.matrix;

/**
 * @author nikhil.k
 *
 */
public class FacebookFriendsGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] friends = {"YYNN" .toCharArray(), "YYYN" .toCharArray(), "NYYN" .toCharArray(), "NNNY" .toCharArray()};
			        System.out.println(getFriendCircles(friends));
	}

	private static int getFriendCircles(char[][] friends) {
		int groups = 0;
		
		if(friends == null || friends.length<1)
			return groups;
		boolean[] visited = new boolean[friends.length];
		
		for(int i = 0 ;i<friends.length;i++){
			visited[i] = false;
		}
		for(int i = 0;i<friends.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				groups++;
				findFriends(visited,friends,i);
			}
		}
		return groups;
	}

	private static void findFriends(boolean[] visited, char[][] friends, int id) {
		for(int i = 0;i<friends[0].length;i++)
		{
			if(id != i && !visited[i] && friends[id][i] == 'Y')
				{
				visited[i] = true;
				findFriends(visited, friends, i);
				}
		}
	}

}
