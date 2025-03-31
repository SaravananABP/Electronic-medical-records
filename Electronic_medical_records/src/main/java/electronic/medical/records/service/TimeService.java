package electronic.medical.records.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class TimeService {
    public static Date getCurrentTimeInIndia() {
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        return Date.from(indiaTime.toInstant());
    }
}
