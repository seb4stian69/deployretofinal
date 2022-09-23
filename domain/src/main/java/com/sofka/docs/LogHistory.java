package com.sofka.docs;

import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.LogHistoryId;
import com.sofka.docs.values.Reason;
import com.sofka.docs.values.Responsible;

import java.time.Instant;

public class LogHistory extends Entity<LogHistoryId> {

    private BlockChainId blockChainId;

    private Instant date;
    private Responsible responsible;
    private Reason reason;

    public LogHistory(LogHistoryId entityId) {
        super(entityId);
    }

    public LogHistory(LogHistoryId entityId, BlockChainId blockChainId, Responsible responsible, Reason reason) {
        super(entityId);
        this.blockChainId = blockChainId;
        this.date = Instant.now();
        this.responsible = responsible;
        this.reason = reason;
    }
}
