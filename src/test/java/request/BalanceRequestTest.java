package request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceRequestTest {
    private final BalanceRequest balanceRequest = new BalanceRequest("DBI", "Sushan", 2);

    @Test
    void shouldReturnUniqueIdentifier() {
        assertEquals("DBI-Sushan", balanceRequest.getIdentifier());
    }
}