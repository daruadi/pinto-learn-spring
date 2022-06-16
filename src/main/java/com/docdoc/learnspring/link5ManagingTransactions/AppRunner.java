package com.docdoc.learnspring.link5ManagingTransactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AppRunner implements CommandLineRunner{

    private final static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookingService bookingService;

    public AppRunner(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        bookingService.book("Alice", "Bob", "Carol");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "3 first booking is all good");
        logger.info("Alice, Bob, Carol is inserted with no problem");
        try {
            bookingService.book("Andy", "Pintoko", "Daruadi");
        } catch (RuntimeException e) {
            logger.info("`Pintoko` name is too wide, max is 5 char");
            logger.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            logger.info(person + " is booked");
        }

        Assert.isTrue(bookingService.findAllBookings().size() == 3, "The size is still 3");

        try{
            bookingService.book("Budi", null);
        } catch(RuntimeException e){
            logger.info("this booking is cancelled because there's null data");
        }

        Assert.isTrue(bookingService.findAllBookings().size() == 3, "the size is still 3, inserted null trigger rollback");
    }
    
}
