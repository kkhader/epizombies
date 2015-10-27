package zombies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import zombies.ReLogoTurtle;

class Human extends ReLogoTurtle {
	
	def infected = false
	def infectionTime=0
	
	def step() {
		
		def winner = minOneOf(neighbors()) {
			count(zombiesOn(it))
			}
			
		face(winner)
		forward(1.5)
		
		if (infected){
			infectionTime++
			if (infectionTime == 1){
			label = "Oh gosh, this isn't good! I don't feel well... I did NOT expect this today :-("
			}
			if (infectionTime == 2){
			label = "Boy, this has been a rough day! I feel like I'm really going downhill..."
			}
			if (infectionTime > 2){
			label = "I really don't feel well! I think I've lost about " + infectionTime/gestationPeriod*100 + "% of my life-force"
			}
			if (infectionTime >= gestationPeriod){
				hatchZombies(1){
					size=1
				}
				die()
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "Human [infected=" + infected + ", infectionTime="
				+ infectionTime + "]";
	}
	
	
	
}
