package com.eliteteachlearn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String input = request.getParameter("lastSect");

        File fileName = new File(getServletContext().getRealPath("assessment_times.txt"));
        Scanner inFile = new Scanner(fileName);

        int totAssessments = 0;

        while (inFile.hasNextLine())
        {
            inFile.nextLine();
            totAssessments++;
        }
        inFile.close();

        String [] assessName = new String [totAssessments];
        int [] sectMin = new int [totAssessments];
        int [] totMin = new int [totAssessments];
        double [] totHoursDeci = new double [totAssessments];
        int [] totHrsTrunc = new int [totAssessments];
        double [] totMinLftOvr = new double [totAssessments];
        double [] totHours = new double [totAssessments];
        int [] partHrsToDay = new int [totAssessments];
        int [] noDays1Hr = new int [totAssessments];
        double [] noWeeksDaily = new double [totAssessments];
        double [] noWeeksWkdys = new double [totAssessments];
        int [] noDays2Hr = new int [totAssessments];
        double [] noWks2HrsDaily = new double [totAssessments];
        double [] noWks2HrsWkdys = new double [totAssessments];
        int [] noDays1HrDayWkDays = new int [totAssessments];
        int [] noDays2HrDayWkDays = new int [totAssessments];

        inFile = new Scanner(fileName);               //reopen the file
        int index = 0;

        while (inFile.hasNext())
        {
            assessName[index] = inFile.next();
            sectMin[index] = inFile.nextInt();
            totMin[index] = inFile.nextInt();
            totHoursDeci[index] = inFile.nextDouble();
            totHrsTrunc[index] = inFile.nextInt();
            totMinLftOvr[index] = inFile.nextDouble();
            totHours[index] = inFile.nextDouble();
            partHrsToDay[index] = inFile.nextInt();
            noDays1Hr[index] = inFile.nextInt();
            noWeeksDaily[index] = inFile.nextDouble();
            noWeeksWkdys[index] = inFile.nextDouble();
            noDays2Hr[index] = inFile.nextInt();
            noWks2HrsDaily[index] = inFile.nextDouble();
            noWks2HrsWkdys[index] = inFile.nextDouble();
            noDays1HrDayWkDays[index] = inFile.nextInt();
            noDays2HrDayWkDays[index] = inFile.nextInt();
            index++;
        }
        inFile.close();

        ArrayList<String> results = new ArrayList<String>();
        for(int n = 0; n < totAssessments; n++)
        {
            //System.out.println(assessName[n].substring(0,5));
            if (input.equals(assessName[n].substring(0,5)))
            {
                results.add( new String("You last completed the " + assessName[n] + " assessment."));
                results.add( new String("You next assessment is the " + assessName[n+1] + " assessment."));

                results.add( new String("Your time left in the course is approximately " + totMin[n] + " minutes."));
                results.add( new String("Your time left in the course is approximately " + totHours[n] + " hours."));

                results.add( new String("If you are willing to put in an 1hr/day, 5 days/wk!"));
                results.add( new String("Your time left in the course is approximately " + noDays1HrDayWkDays[n] + " days working 1hr/day - 5days/wk."));
                results.add( new String("Your time left in the course is approximately " + noWeeksWkdys[n] + " weeks working 1hr/day - 5days/wk."));

                results.add( new String("If you are willing to put in an 2hr/day, 5 days/wk!"));
                results.add( new String("Your time left in the course is approximately " + noDays2HrDayWkDays[n] + " days working 2hrs/day - 5days/wk."));
                results.add( new String("Your time left in the course is approximately " + noWks2HrsWkdys[n] + " weeks working 1hr/day - 5days/wk."));

                results.add( new String("If you are willing to put in an 1hr/day, 7 days/wk!"));
                results.add( new String("Your time left in the course is approximately " + noDays1Hr[n] + " days working 1hr/day - 7days/wk."));
                results.add( new String("Your time left in the course is approximately " + noWeeksDaily[n] + " weeks working 1hr/day - 7days/wk."));

                results.add( new String("If you are willing to put in an 2hrs/day, 7 days/wk!"));
                results.add( new String("Your time left in the course is approximately " + noDays2Hr[n] + " days working 2hrs/day - 7days/wk."));
                results.add( new String("Your time left in the course is approximately " + noWks2HrsDaily[n] + " weeks working 2hrs/day - 7days/wk."));
            }

        }

        //String test = results.get(10);
        response.getWriter().println("Your Approx Time Left in the Course");
        response.getWriter().println();
        //response.getWriter().println("TSum is " + index + totAssessments);
       // response.getWriter().println(test);

        for(int i=0;i<results.size();i++) {
            response.getWriter().println(results.get(i));
        }
    }
}
