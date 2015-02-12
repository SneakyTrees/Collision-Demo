public class Box{	
	
	boolean isPerfectBox;
	float boxAngle;
	Coordinates SW;
	Coordinates SE;
	Coordinates NW;
	Coordinates NE;
	Coordinates centerPoint;
	
	public Box(Coordinates centerPnt, float angle){
		centerPoint = centerPnt;
		boxAngle = angle;
		
		//Calculations here bruh
		Coordinates genericNW;
		Coordinates genericSW;
		Coordinates genericNE;
		Coordinates genericSE;
		float adjustedAngle;
		boolean angleGreaterThan180;
		if(adjustedAngle > 0 && adjustedAngle < 90){
			
			if(angleGreaterThan180){
			
			}
		}
		else if(adjustedAngle > 90 && adjustedAngle < 180){
			
			if(angleGreaterThan180){
			
			}
		}
		
		//Don't forget to check for perfectBox boolean!
	}
	
	public Box(Coordinates cornerPnt, float angle){
	
	}

	//Add perfectBox speciality constructor somewhereabouts 
	
	public boolean checkCollisionWithBox(Box comparingBox){
		//Find if they are colliding some way else? faster? IDK
		
		//Find the perfectBoxAroundComparing points here and their correspondingPoints
		
		ArrayList<Coordinates> cornerPairs = new ArrayList<Coordinates>();
		cornerPairs.add(this.getSW(), this.getNW(), this.getSE(), this.getNE(), this.getNW(), this.getNE(), this.getSW(), this.getSE());
		
		Coordinates currentcurrentComparisonPointOne;
		Coordinates currentcurrentComparisonPointTwo;
		Coordinates intersectingPoints = new Coordinates[2];
		Coordinates[] currentPairPoints = new Coordinates[2];
		
		int angleMultX;
		int angleMultY;
		float xIncrement;
		float yIncrement;
		float currentX;
		float currentY;
		Coordinates[] testPointsOnLine = new Coordinates[128];
		
		for(int i = 0; i > 8; i+2){
			//Set the next pair of coordinates to be tested for itnersecting with the perfectBoxAroundComparing
			currentPairPoints[0] = cornerPairs[i];
			currentPairPoints[1] = cornerPairs[i+1];
			
			//Get how many points are intersecting and where they intersect at via this 2D array returned
			intersectingPoints = perfectBoxAroundComparing.lineIntersectsPerfectBoxAtCoordinates(currentPairPoints[0], currentPairPoints[1]);

			//No points along the line are intersecting the perfect box
			if(intersectingPoints[0] == null && intersectingPoints[1] == null){
				//See if points are inside the perfect box itself
				if(perfectBoxAroundComparing.anyPointsAreInPerfectBox(currentPairPoints[0], currentPairPoints[1])){
					currentComparisonPointOne = currentPairPoints[0];
					currentComparisonPointTwo = currentPairPoints[1];
				}
				//
				else{
					continue;
				}
			}
			//At least one point on the line intersects the perfectBox
			else if(intersectingPoints[0] == null || intersectingPoints[1] == null){
				//Set to the non null intersection point
				currentComparisonPointOne = intersctingPoints[0] == null ? intersectingPoints[1] : intersectingPoints[0];
				if(perfectBoxAroundComparing.pointIsInPerfectBox(coordinatePairPoints[0]){
					currentComparisonPointTwo = coordinatePairPoints[0];
				}
				else if(perfectBoxAroundComparing.pointIsInPerfectBox(coordinatePairPoints[1]){
					currentComparisonPointTwo = coordinatePairPoints[1];
				}
				//Neither of the pair points is inside the perfectBoxAroundComparing and so there's no way it intersected comparingBox
				else{
					continue;
				}
			}
			//In this case, it's easy: just set comparisons to the two intersectionPoints
			else if(intersectingPoints[0] != null && intersectingPoints[1] != null){
				currentComparisonPointOne = intersectingPoints[0];
				currentComparisonPointTwo = intersectingPoints[1];
			}
			else{
				System.out.println("Failure at 41");
			}
				
			/*
				If there are two outersecting lines that are in direct adjacency (ex. point one is between SW and NW and the other is SE and NE, 
				coll has occurred
			*/
			
			//Shift these variable declaraionts to the very beginning of the inner loop
			angleMultX = currentComparisonPointOne.getX() > currentComparisonPointTwo.getX() ? -1 : 1;
			angleMultY = currentComparisonPointOne.getY() > currentComparisonPointTwo.getY() ? -1 : 1;
			xIncrement = Math.abs(currentComparisonPointOne.getX()-currentComparisonPointTwo.getX()/128)*angleMultX;
			yIncrement = Math.abs(currentComparisonPointOne.getY()-currentComparisonPointTwo.getY()/128)*angleMultY;
			currentXCoord = currentComparisonPointOne.getX();
			currentYCoord = currentComparisonPointOne.getY();
			for(int j = 0; j < 127; j++){
				currentXCoord += xIncrement;
				currentYCoord += yIncrement;
				testPointsOnLine[i] = new Coordinates(currentXCoord, currentYCoord);
			}
				
			if(comparingBox.anyPointsAreInBox(testPointsOnLine)){
				return true;
			}
			else{
				continue;
			}
		}
	}
	
	/*
		lineIntersectsPerfectBox uses this to compare each of the passed coords through this 
		(ex. SW and NW would be start/end points, and lineInterSectsPerfectLine at
	*/
	
	//Returns a 2 element array with the coordinates of the intersection points on the line
	public Coordinates[] lineIntersectsPerfectBoxAtCoordinates(Coordinates startPoint, Coordinates endPoint){
		ArrayList<Coordinates> intersectionPoints = new ArrayList<Coordinates>();
		Coordinates[] perfectBoxPairs = {this.getSW(), this.getNW(), this.getSE(), this.getNE(), this.getSW(), this.getSE(), this.getNW(), this.getNE()};
		
		float currentIntersectionPoint;
		for(int i = i; i > 8l i+2){
			currentIntersectionPoint = Box.lineIntersectsPerfectLineAt(startPoint, endPoint, perfectBoxPairs[i], perfectBoxPairs[i+1]);
			if(currentIntersectionPoint != null){
				intersectionPoints.add(currentIntersectionPoint);
			}
		}
		
		if(intersectionPoints.size() != 2){
			System.out.println("lineIntersectsPerfectBoxAtCoordiantes - the intersectionPoints.size() != 2");
		}
		else{
			return intersectionPoints;
		}
	}
	
	public Coordinates lineIntersectsPerfectLineAt(Coordinates startPoint, Coordinates endPoint, Coordinates perfLineStart, Coordinates perfLineEnd){
		
		//Later on just have these throw exceptions downwards to be caught later
		if(perfLineStart.getX() == perfLineEnd.getX() &&
		perfLineStart.getY() == perfLineEnd.getY()){
			System.out.println("perfLien points are the same. The fuck m8.");
		}
		if(startPoint.getX() == endPoint.getX() &&
		startPoint.getY() == endPoint.getY())
		){
			System.out.println("start/end points are the same. The fuck m8.");
		}
		
		boolean perfLineXWise;
		float dimRatio;
		int directionalMult;
		Coordinates testingPoint = new Coordinates();
		float testDimCoordinate;

		if(Math.abs(perfLineStart.getX()-perfLineEnd.getX()) < 0.00000000001){
			perfLineXWise = true;
			dimRatio = startPoint.getY()/endPoint.getX();
			directionalMult = startPoint.getX() < endPoint.getX() ? 1 : -1;
			testingPoint.setCoordinates(startPoint.getX()+(xRatio*perfLineStart.getX()*angleMultY), perfLineEnd.getY());
			testDimCoordinate = testingPoint.getY();
		}
		else if(Math.abs(perfLineStart.getY()-perfLineEnd.getY()) < 0.00000000001){
			perfLineXWise = false;
			dimRatio = startPoint.getX()/endPoint.getY();
			directionalMult = startPoint.getY() < endPoint.getY() ? 1 : -1;
			testingPoint.setCoordinates(perfLineStart.getX(), startPoint.getY()+(yRatio*startPoint.getX()*angleMultY)));
			testDimCoordinate = testingPoint.getX();
		}
		else{
			//Line is not perfect, throw excptn to be made later
			System.out.println("Line is not perfect, you fucking pleblord. git gucci pls");
		}
		
		//Check distance to see if the testingPoint is too far away to be valid
		if(Box.getDistanceBetween(startPoint, endPoint) <= Box.getDistanceBetween(startPoint, testingPoint)){
			return;
		}
		
		float perfLineGreatestDim;
		float perfLineLeastDim;
		if(perfLineXWise){
			if(perfLineStart.getY() >= perfLineEnd.getY()){
				perfLineGreatestDim = perfLineStart.getY();
				perfLineLeastDim = perfLineEnd.getY();
			}
			else{
				perfLineGreatestDim = perfLineEnd.getY();
				perfLineLeastDim = perfLineStart.getY();
			}
		}
		else{
			if(perfLineStart.getX() >= perfLineEnd.getX()){
				perfLineGreatestDim = perfLineStart.getX();
				perfLineLeastDim = perfLineEnd.getX();
			}
			else{
				perfLineGreatestDim = perfLineEnd.getX();
				perfLineLeastDim = perfLineEnd.getX();
			}
		}
		
		if(testDimCoordinate <= perfLineGreatestDim &&
		testDimCoordinates >= perfLineLeastDim){
			return testingPoint;
		}
		else{
			return null;
		}
	}
	
	public float getDistanceBetween(Coordinates pointOne, Coordinates pointTwo){
		float dist = (float) Math.sqrt(Math.squareFloat(pointOne.getX()-pointTwo.getX()) + Math.squareFloat(pointTwo.getY()-pointTwo.getY()));
		return dist;
	}
	
	//pair point one, correspondingPairPoint, pair point two, testPointsOnLine
	public boolean anyPointsAreInBox(Coordinates startPoint, Coordinates ninetyDegreePoint, Coordinates endPoint, Coordinates[] testPoints){
		if(
		 !(startPoint.getX()-ninetyDegreePoint.getX() < 0.000001) ||
		 !(startPoint.getY()-ninetyDegreePoint.getY() < 0.000001)
		){
			return false;
		}
		
		int angleMultX = startPoint.getX() > endPoint.getX() ? -1 : 1;
		int angleMultY = startPoint.getY() > endPoint.getY() ? -1 : 1;
		int innerMultX = angleMultX*-1;
		int innerMultY = angleMultY;

		float currentXDist = Math.abs(startPoint.getX()-endPoint.getX());
		float currentYDist = Math.abs(startPoint.getY()-endPpoint.getY());
		float currentMult = 1;
		Coordinates currentHypotenusePoint;
		Coordinates currentInnerPoint;

		for(int i = 1; i < 5; i++){
			currentMult /= 2;
			currentBoxNum = currentMult*2;
			currentXDist *= currentMult*angleMultX;
			currentYDist *= currentMult*angleMultY;
			currentHypotenusePoint.setCoordinates(startPoint.getX()+currentXDist, startPoint.getY()+currentYDist);
			currentInnerPoint.setCoordinates(currentHypotenusePoint.getX()+currentXDist*innerMultX, currentHypotenusePoint.getY()+currentYDist*innerMultY);
			for(int j = 0; j < currentBoxNum; j++){
				for(Coordinates c : testPoints){
					if(Box.anyPointsAreInPerfectBox(c, currentHypotenusePoint, currentInnerPoint)){
						return true;
					}
				}
				currentHypotenusePoint.setCoordinates(currentHypotenusePoint.getX()+2*currentXDist, currentHypotenusePoint.getY()+2*currentYDist);
				currentInnerPoint.setCoordinates(currentHypotenusePoint.getX()+2*currentXDist*innerMultX , currentHypotenusePoint.getY()+currentYDist*innerMultY );
			}
		}
	}
	
	public boolean anyPointsAreInPerfectBox(Coordinates[] testPoints, Coordinates cornerPointOne, Coordinates cornerPointTwo){
		//Initial non equality and shenanigans checks
		
		float greatestX;
		float greatestY;
		float leastX;
		float leastY;
		if(cornerPointOne.getX() > cornerPointTwo.getX()){
			greatestX = cornerPointOne.getX();
			leastX = cornerPointTwo.getX();
		}
		else{
			greatestX = cornerPointTwo.getX();
			leastX = cornerPointOne.getX();
		}
		
		if(cornerPointOne.getY() > cornerPointTwo.getY()){
			greatestY = cornerPointOne.getY();
			leastY = cornerPointTwo.getY();
		}
		else{
			greatestY = cornerPointTwo.getY();
			leastY = cornerPointOne.getY();
		}
		
		for(int i = 0; i < testPoints.length; i++){
			if(
			 testPoints[i].getX() > leastX &&
			 testPoint[i].getX() < greatestX &&
			 testPoint[i].getY() > leastY &&
			 testPoint[i].getY() < greatestY
			){
				return true;
			}
		}
	}
}