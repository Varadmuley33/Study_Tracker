import java.time.LocalDate;

class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate date, String subject, double duration, String description)
    {
        this.Date = date;
        this.Subject = subject;
        this.Duration = duration;
        this.Description = description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}