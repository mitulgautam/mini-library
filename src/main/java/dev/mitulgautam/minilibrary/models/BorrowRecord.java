package dev.mitulgautam.minilibrary.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class BorrowRecord {
    UUID borrowerRecordId;
    LocalDateTime borrowedDate;

    LocalDateTime returnedDate;

}
