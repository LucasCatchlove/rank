// -------------------------------------------------------
// Assignment 3
// Written by: Lucas catchlove 27145640
// For COMP 248 Section (section U) – Winter 2020
// --------------------------------------------------------
/* This program allows the user to enter any given number of teams (of size 6)
   and prints out the players scores and rank as well as the overall team score 
   and rank. The data is displayed in a table for the user to see.  
 */

import java.util.Scanner; 

public class Rank {
	public static void main(String[] args) {

		System.out.println("*****************************************\n" +
				"           IMO Participant Ranker           \n" + 
				"*****************************************\n"); 

		Scanner kb = new Scanner(System.in);

		//receives number of teams from user
		System.out.print("Enter the number of teams: ");
		int teamCount = kb.nextInt();


		//declaration and initialization of arrays
		int[][] scores;
		int[] teamScores;
		int[] teamRanks; 

		scores = new int[teamCount][6];
		teamScores= new int[scores.length];
		teamRanks = new int[scores.length];

		
		//receives player scores for each team from user
		for(int i=0; i<teamCount; i++) {
			for (int j=0; j<6; j++) {
			System.out.print("Enter player " + (j+1) + " on team " + (i+1) + ": ");
			scores[i][j] = kb.nextInt();
			}


		}
		//prints table header
		System.out.println("\nThe ranking list:");
		System.out.println("  P1    P2    P3     P4    P5    P6  ");

		
		for (int i = 0; i<scores.length; i++) {

			//calculates the rank of each player
			for (int j =0; j<scores[i].length; j++ ) {

				int playerScore= scores[i][j];
				int playerRank=0;

				for (int k = 0; k<scores.length; k++) {

					for (int l =0; l<scores[k].length; l++ ) {

						if(scores[k][l] > playerScore)
							playerRank++;

						if(i==0 && j==0)
							teamScores[k] += scores[k][l];

					}

				}

				playerRank++;

				//calculates the rank of each team
				if (i==0 && j==0) {

					for(int m = 0; m<teamScores.length; m++) {

						for(int n = 0; n<teamScores.length; n++) {

							if(teamScores[m] < teamScores[n]) 
								teamRanks[m]++;

						}
						teamRanks[m]++;
					}

				}
				//prints out score and rank of each player on team 
				System.out.print(playerScore+ "("+ playerRank +") ");

			}
			//prints out score and rank of each team 
			System.out.print("team"+(i+1)+" score: " +teamScores[i]+" team"+(i+1)+" rank: " +teamRanks[i]+"\n");
			

		}
		System.out.println("\nThank you for using IMO Participant Ranker! Goodbye!\n");
	}
}