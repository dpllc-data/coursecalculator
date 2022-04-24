package com.eliteteachlearn;


// import statements
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Servlet class handles user input, aggregation of data, and posting of desired data
/**
 * The purpose of this servlet class is to service HTTP requests from the
 * web client class. More specifically the class handles the backend tasks
 * associated with; obtaining user input for the last assignment completed,
 * loading time data needed to produce user results, creating a subset of
 * that data that is pertinent to the user, storing the resulting data and
 * passing that data on as an HTTP service request.
 *
 * @author Stan Shelton
 * @version 1.05
 * date April 23, 2022
 */
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    /**
     * The service method is handling the footwork (input, aggregation, storage and posting)
     * @param request creates object passed as argument
     * @param response creates object passed as argument
     * @throws IOException if an input or output error occurs while the servlet is handling the HTTP request
     * @throws ServletException if the HTTP request cannot be handled
     */
    @Override // Override service method allowing servlet to handle requests
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //input for last assignment completed and the corresponding course
        String lastSect = request.getParameter("lastSect");
        String courseName = request.getParameter("courseName");

        // control statement for loading the corresponding course data
        File fileName = null;
        if (courseName.equals("APCSA1"))
            fileName = new File(getServletContext().getRealPath("APCSA1.txt"));
        if (courseName.equals("APCSA2"))
            fileName = new File(getServletContext().getRealPath("APCSA2.txt"));
        if (courseName.equals("DIT1"))
            fileName = new File(getServletContext().getRealPath("DITSem1.txt"));
        if (courseName.equals("DIT2"))
            fileName = new File(getServletContext().getRealPath("DITSem2.txt"));
        if (courseName.equals("FOP1"))
            fileName = new File(getServletContext().getRealPath("FOPSem1.txt"));
        if (courseName.equals("FOP2"))
            fileName = new File(getServletContext().getRealPath("FOPSem2.txt"));

        // scanner in find the length of the text file holding the corresponding data
        Scanner inFile = new Scanner(fileName);

        int totAssessments = 0;

        while (inFile.hasNextLine()) {
            inFile.nextLine();
            totAssessments++;
        }
        inFile.close();

        // Data structure declarations and initializations
        String[] assessName = new String[totAssessments];
        int[] sectMin = new int[totAssessments];
        int[] totMin = new int[totAssessments];
        double[] totHoursDeci = new double[totAssessments];
        int[] totHrsTrunc = new int[totAssessments];
        double[] totMinLftOvr = new double[totAssessments];
        double[] totHours = new double[totAssessments];
        int[] partHrsToDay = new int[totAssessments];
        int[] noDays1Hr = new int[totAssessments];
        double[] noWeeksDaily = new double[totAssessments];
        double[] noWeeksWkdys = new double[totAssessments];
        int[] noDays2Hr = new int[totAssessments];
        double[] noWks2HrsDaily = new double[totAssessments];
        double[] noWks2HrsWkdys = new double[totAssessments];
        int[] noDays1HrDayWkDays = new int[totAssessments];
        int[] noDays2HrDayWkDays = new int[totAssessments];

        // read corresponding course data from text file into data structures
        inFile = new Scanner(fileName);               //reopen the file
        int index = 0;

        while (inFile.hasNext()) {
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

        // Create and load up separate data structure containing only pertinent results
        ArrayList<String> results = new ArrayList<String>();
        for (int n = 0; n < totAssessments; n++){
            //System.out.println(assessName[n].substring(0,5));
            if (lastSect.equals(assessName[n].substring(0, 5))) {

                // build BOTH request object && ArrayList structure for flexibility
                results.add(new String("Your last completed the " + assessName[n] + " assessment."));
                request.setAttribute("line1", "Your last completed the " + assessName[n] + " assessment.");
                results.add(new String("Your next assessment is the " + assessName[n + 1] + " assessment."));
                request.setAttribute("line2", "Your next assessment is the " + assessName[n + 1] + " assessment.");

                results.add(new String("TOTAL TIME: Your time left in the course is approximately " + totMin[n] + " minutes."));
                request.setAttribute("line3", "TOTAL TIME: Your time left in the course is approximately " + totMin[n] + " minutes.");
                results.add(new String("TOTAL TIME: Your time left in the course is approximately " + totHours[n] + " hours."));
                request.setAttribute("line4", "TOTAL TIME: Your time left in the course is approximately " + totHours[n] + " hours.");

                results.add(new String("If you are willing to put in an 1hr/day, 5 days/wk!"));
                request.setAttribute("line5", "If you are willing to put in an 1hr/day, 5 days/wk!");
                results.add(new String("Your time left in the course is approximately " + noDays1HrDayWkDays[n] + " days working 1hr/day - 5days/wk."));
                request.setAttribute("line6", "Your time left in the course is approximately " + noDays1HrDayWkDays[n] + " days working 1hr/day - 5days/wk.");
                results.add(new String("Your time left in the course is approximately " + noWeeksWkdys[n] + " weeks working 1hr/day - 5days/wk."));
                request.setAttribute("line7", "Your time left in the course is approximately " + noWeeksWkdys[n] + " weeks working 1hr/day - 5days/wk.");

                results.add(new String("If you are willing to put in an 2hrs/day, 5 days/wk!"));
                request.setAttribute("line8", "If you are willing to put in an 2hrs/day, 5 days/wk!");
                results.add(new String("Your time left in the course is approximately " + noDays2HrDayWkDays[n] + " days working 2hrs/day - 5days/wk."));
                request.setAttribute("line9", "Your time left in the course is approximately " + noDays2HrDayWkDays[n] + " days working 2hrs/day - 5days/wk.");
                results.add(new String("Your time left in the course is approximately " + noWks2HrsWkdys[n] + " weeks working 1hr/day - 5days/wk."));
                request.setAttribute("line10", "Your time left in the course is approximately " + noWks2HrsWkdys[n] + " weeks working 2hr/day - 5days/wk.");

                results.add(new String("If you are willing to put in an 1hr/day, 7 days/wk!"));
                request.setAttribute("line11", "If you are willing to put in an 1hr/day, 7 days/wk!");
                results.add(new String("Your time left in the course is approximately " + noDays1Hr[n] + " days working 1hr/day - 7days/wk."));
                request.setAttribute("line12", "Your time left in the course is approximately " + noDays1Hr[n] + " days working 1hr/day - 7days/wk.");
                results.add(new String("Your time left in the course is approximately " + noWeeksDaily[n] + " weeks working 1hr/day - 7days/wk."));
                request.setAttribute("line13", "Your time left in the course is approximately " + noWeeksDaily[n] + " weeks working 1hr/day - 7days/wk.");

                results.add(new String("If you are willing to put in an 2hrs/day, 7 days/wk!"));
                request.setAttribute("line14", "If you are willing to put in an 2hrs/day, 7 days/wk!");
                results.add(new String("Your time left in the course is approximately " + noDays2Hr[n] + " days working 2hrs/day - 7days/wk."));
                request.setAttribute("line15", "Your time left in the course is approximately " + noDays2Hr[n] + " days working 2hrs/day - 7days/wk.");
                results.add(new String("Your time left in the course is approximately " + noWks2HrsDaily[n] + " weeks working 2hrs/day - 7days/wk."));
                request.setAttribute("line16", "Your time left in the course is approximately " + noWks2HrsDaily[n] + " weeks working 2hrs/day - 7days/wk.");
                request.setAttribute("line17", "-------------------------------------------------------------");

            }
    }
            // catches improper requests made by user; forces restart of user prompt
            if (results.isEmpty()) {
                results.add(new String("You entered " + lastSect + ". Please go back. Check that you are have selected the correct course " +
                        " AND the correct semester!"));
                request.setAttribute("line1", "You entered " + lastSect + ". Please go back. Check that you are have selected the correct course " +
                        " AND the correct semester.");
            }

/*
            //String test = results.get(10);
            response.getWriter().println("APCSA2 Time Left in Course Estimator");
            response.getWriter().println();
            response.getWriter().println("We all work at different speed, so use this as a relative tool, not an absolute " +
                    "statement of time left in the course.");
            response.getWriter().println("Make adjustments to these numbers if you see yourself working " +
                    "faster or slower than what is estimated.");
            response.getWriter().println();
 */
/*
            for (int i = 0; i < results.size(); i++) {
                response.getWriter().println(results.get(i));
                if (i == 1) {
                    response.getWriter().println();
                }
                if (i == 3) {
                    response.getWriter().println();
                }
                if (i == 6) {
                    response.getWriter().println();
                }
                if (i == 9) {
                    response.getWriter().println();
                }
                if (i == 12) {
                    response.getWriter().println();
                }
                if (i == 15) {
                    response.getWriter().println();
                }
            }
*/
        //forward data object to frontend
        request.setAttribute("results", results);
            getServletContext().getRequestDispatcher("/report").forward(request, response);
            //response.sendRedirect("http://localhost:8080/HelloWorld/test");

        }
    }

