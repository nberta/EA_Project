package edu.miu.cs.airlineregistrationsystem.emailservice.service;

import edu.miu.cs.airlineregistrationsystem.emailservice.service.request.ScheduleEmailRequest;
import edu.miu.cs.airlineregistrationsystem.emailservice.service.response.ScheduleEmailResponse;
import org.quartz.SchedulerException;

import java.time.ZonedDateTime;

public interface EmailSchedulingService {

    ScheduleEmailResponse schedule(ScheduleEmailRequest request, ZonedDateTime dateTime) throws SchedulerException;
}
