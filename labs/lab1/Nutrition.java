package lab1;
import cse131.ArgsProcessor;
public class Nutrition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
        String name = ap.nextString("food name");
        double carbs = ap.nextDouble("grams of carbohydrates");
        double fat = ap.nextDouble("grams of carbohydrates");
        double protein = ap.nextDouble("grams of protein");
        int statedCals = ap.nextInt("stated Calories");
        double carbsCal = Math.round(carbs*4*100)/100.0;
        double fatCal = Math.round(fat*9*100)/100.0;
        double proteinCal = Math.round(protein*4*100)/100.0;
        double totalCal = Math.round((proteinCal + fatCal + carbsCal)*100)/100.0;
        double unavailableCal = Math.round((totalCal - statedCals)*100)/100.0;
        double fiber = unavailableCal/4.0;
        double CarbsPercent = Math.round(carbsCal/statedCals*1000)/10.0;
        double fatPercent = Math.round(fatCal/statedCals*1000)/10.0;
        double proteinPercent = Math.round(proteinCal/statedCals*1000)/10.0;
        boolean lowcarbs =(CarbsPercent<25);
        boolean lowfat = (fatPercent<15);
        boolean heads = (Math.random()>0.5);
        System.out.println(name+" has");
        System.out.println(carbs+" grams of carbohydrates = "+carbsCal+" Calories");
        System.out.println(fat+" grams of fat = "+fatCal+" Calories");
        System.out.println(protein+" grams of protein = "+proteinCal+" Calories");
        System.out.println();
        System.out.println("This food is said to have "+statedCals+" (available) Calories.");
        System.out.println("With "+unavailableCal+" unavailable Calories, this food has "+fiber+" grams of fiber");
        System.out.println("Approximately"+'\n'+'\t'+CarbsPercent+"%"+" of your food is carbohydrates"+'\n'+'\t'+fatPercent+"%"+" of your food is fat"+'\n'+'\t'+proteinPercent+"%"+" of your food is protein");
        System.out.println("This food is acceptable for a low-carb diet?  "+lowcarbs);
        System.out.println("This food is acceptable for a low-fat diet?  "+lowfat);
        System.out.println("By coin flip, you should eat this food?   "+heads);
          
	}

}
