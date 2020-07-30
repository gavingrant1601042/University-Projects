# Jodene Garvey
# Gavin Grant
# Tia O'Gilvie
# Ashley Walker

from tkinter import *
import tkinter.messagebox
import os


global total
global TotalDengue
global fever
total = 0
TotalDengue = 0
fever = 0






#Expert Database: Adds Symptoms to database.
class Expert:
    def __init__(self,win2):
        self.win2 = win2
        self.L1 = Label(win2, text = "Enter Possible Symptoms:")
        self.L1.place(x = 10,y = 10)
        self.name = Entry(win2, bd = 5)
        self.name.place(x = 150,y = 10)
        self.B1 = Button(win2, text = "Enter", command = self.getval)
        self.B1.place(x = 150,y = 90)

        self.Quit = Button(win2,text="Close", command=self.QuitExpert)
        #self.close = Button (self.stat, text="CLOSE", command=self.Close)

        self.Quit.place (x=240, y=90)

    def QuitExpert(self):
        self.win2.destroy ();


    def getval(self):
        Dengue_Symptom = self.name.get()
        file = open("DengueSymptoms.txt","a")
        file.write("%s\n" %(Dengue_Symptom))
        file.close()
        #Information Box
        tkinter.messagebox.showinfo("Information","Symptom Recorded")
# Allow Users of the System to Enter Information
class UserDiagnosis:
    
    def __init__(self, window):
        self.window = window

        self.L1 = Label(self.window, text = "Enter Full Name:")
        self.L1.place(x = 10,y = 10)
        self.name = Entry(self.window,bd = 5)
        self.name.place(x = 150,y = 10)

        self.L2 = Label(self.window, text = "Enter Your Temperature (°C):")
        self.L2.place(x = 10,y = 50)
        self.temp = Entry(self.window,bd = 5)
        self.temp.place(x = 180,y = 50)

        self.H = Label(self.window, text = "Please Identify Your Symptoms:")
        self.H.place(x =10, y =90)

        self.sym1 = Entry(self.window,bd = 3)
        self.sym1.place(x =210,y =90)

        self.sym2 = Entry(self.window,bd = 3)
        self.sym2.place(x =210,y =110)

        self.sym3 = Entry(self.window,bd = 3)
        self.sym3.place(x =210,y =130)

        self.Btn = Button(self.window, text = "Check", command = self.Tempcheck)
        self.Btn.place(x = 150, y = 170)

        self.Quit = Button (window, text="Close", command=self.Quit)
        self.Quit.place (x=250, y=170)

    def Quit(self):
        self.window.destroy ();

    def Tempcheck(self):
        global total
        f = open("Patient.txt","a")
        Patient = open("PatientRecords.txt","a")
        self.Ctemp = int(self.temp.get())
        self.pname = self.name.get()
        self.pfever = 0
        self.Ftemp = StringVar()
        self.S1 = self.sym1.get()
        self.S2 = self.sym2.get()
        self.S3 = self.sym3.get()



        self.pfever = (self.Ctemp * 9/5)+32
        total += 1
        if self.pfever > 104:
            self.Ftemp = float(self.pfever)

            
            self.l = Label(self.window,text = self.pname+ " you have a fever of: ",fg = "blue")
            self.l.place(x = 150, y = 200)
            self.Temp = Label(self.window,text = self.Ftemp,fg = "blue")
            self.Temp.place( x = 150, y = 220)
            
            
            f.write("Name: %s \t Temperature: %d \nSymptoms: \n%s\n%s\n%s\n" %(self.pname,self.Ftemp,self.S1,self.S2,self.S3))
            f.close()

            Patient.write("Name: %s \t Temperature: %d \nSymptoms: %s\t%s\t%s\n" %(self.pname,self.Ftemp,self.S1,self.S2,self.S3))
            Patient.close() 


            self.Btn = Button(self.window, text="DIAGNOSE ME", command = self.DengueDiagnosis)
            self.Btn.place(x = 150,y = 250)
            
        elif self.pfever >98 and self.pfever< 100:
                self.Ftemp = float(self.pfever)

                self.label = Label(self.window,text = self.pname+ " You have a low fever of: ",fg = "blue")
                self.label.place(x = 150, y = 200)
                self.SDengue = Label(self.window,text = self.Ftemp,fg = "blue")
                self.SDengue.place(x = 150, y = 220)


                tkinter.messagebox.showinfo("Information","PLEASE SEE YOUR DOCTOR IMMEDIATELY!!!")
        else:
            if self.pfever<98:
                self.lbl = Label(self.window,text = self.pname+ " you have no fever",fg = "blue")
                self.lbl.place(x = 150, y = 200)
 

    def DengueDiagnosis(self):
        global TotalDengue
        points=0
        sys = open("Patient.txt","r")#open files that store patient info.
        symptom = open("DengueSymptoms.txt","r") # open the symptom text file.
        Dengue = symptom.readlines() #stores the info in the symptom file in a list. 
        sys.seek(43)#finds the locaton of the patient file where the symptoms are
        S = sys.readlines(-43)
        sys.close()
        symptom.close()
        for item in Dengue:# comapares each value of the patient symptom with the symptoms stored.
            for item2 in S:
                if item == item2:
                    points += 1 #increment each time that a match is found
                else:
                    pass
                
        # if the matches arr two or more the user have dengue
        TotalDengue += 1
        if points >=2:
           
    
           self.result = Label(self.window,text ="You Have Dengue Fever",fg = "red")
           self.result.place(x =150, y = 280)
           self.Treatment = Button(self.window, text = "RECOMENDED TREATMENT",command = self.DengueTreatment)
           self.Treatment.place(x = 150, y = 300)
           
        else:
            tkinter.messagebox.showinfo("Information","You Don't Have Dengue Fever")

        os.remove("C:\\Users\\joden\\Desktop\\Artificial Intelligence\\Prolog Lab\Patient.txt")# deletes the patient info after diagnosis

    def DengueTreatment(self):
        Diagnosis = open("PatientRecords.txt","a")
            
        self.label = Label(self.window, text = "Please Follow These Recommended Treatments:",fg = "red")
        self.label.place(x = 150, y = 320)
        self.treatment1 = Label(self.window, text = "SEE LOCAL HELTHCARE PROVIDER",fg = "red")
        self.treatment1.place(x = 150, y = 350)
        self.treatment2 = Label(self.window, text = "TAKE PARACETAMOL TO REDUCE FEVER and PAIN",fg = "red")
        self.treatment2.place(x = 150, y = 370)
        self.treatment3 = Label(self.window, text = "DRINK PLENTY OF FLUIDS",fg = "red")
        self.treatment3.place(x = 150, y = 390)

        Diagnosis.write("Diagnosis: Dengue Fever\n")

        self.close = Button(self.window, text = "CLOSE", command = self.Close)
        self.close.place(x = 200, y = 420)

    def Close(self):
        self.window.destroy()
        
        

    


class DisplayStats:
    def __init__(self,stat):
        global total
        global TotalDengue
        self.stat = stat

        self.label = Label(self.stat, text = "Statistics Related to Dengue Diagnosis").pack()
        
        self.Total = Label(self.stat, text = "Total Amount of Persons to Use System: "+str(total))
        self.Total.place(x = 100,y = 40)
        self.Dengue = Label(self.stat, text = "Total Diagnosed with Dengue Fever: " +str(TotalDengue))
        self.Dengue.place(x = 100,y = 80)

        self.close = Button(self.stat, text = "CLOSE",command = self.Close)
        self.close.place(x = 170, y = 140)

    def Close(self):
        self.stat.destroy()


#Main GUI
class GUI:
    def __init__(self, win1):
        self.win1 = win1
        self.B1 = Button(win1, text = "ADD SYMPTOMS", command = self.ExpertWin)
        self.B1.place(x = 150,y = 20)
        self.B2 = Button(win1, text = "DIAGNOSIS", command = self.UserDiagnosis)
        self.B2.place(x = 150,y = 60)
        self.B3 = Button(win1, text = "DISPLAY STATISTCS", command = self.DisplayStats)
        self.B3.place(x = 150,y = 100)

        self.B4 = Button (win1, text="Exit to Desktop", command =self.QuitGUI)
        self.B4.place(x = 150,y = 150)

    def QuitGUI(self):
        self.win1.destroy ();


    
   #Display GUI
    def ExpertWin(self):
        top2 = Tk()
        GUI=Expert(top2)
        top2.title('Add Symptoms')
        top2.geometry("500x500+10+10")
        top2.mainloop()
    #Display GUI
    def UserDiagnosis(self):
        top=Tk()
        myWin=UserDiagnosis(top)
        top.title('Dengue Diagnosis')
        top.geometry("500x500+10+10")
        top.mainloop()
    def DisplayStats(self):
       stat = Tk()
       S=DisplayStats(stat)
       stat.title("Statistics")
       stat.geometry("400x200+10+10")
       stat.mainloop()






#Display Main GUI
top1 = Tk()
mywin1=GUI(top1)
top1.title('Dengue Diagnosis System')
top1.geometry("400x200+10+10")
top1.mainloop()


