package com.github.akosbordas.ncore;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TorrentDetailsParseExceptionTest {

    private TorrentDetailsParseException exception;

    @Test
    public void shouldConstructException() throws Exception {
        exception = new TorrentDetailsParseException("test message");
        assertThat(exception).hasMessage("test message");
        assertThat(exception).hasNoCause();

        RuntimeException cause = new RuntimeException("cause");
        exception = new TorrentDetailsParseException(cause);
        assertThat(exception).hasCause(cause);

        exception = new TorrentDetailsParseException("test message", cause);
        assertThat(exception).hasMessage("test message");
        assertThat(exception).hasCause(cause);

        exception = new TorrentDetailsParseException();
        assertThat(exception).hasNoCause();
        assertThat(exception).hasMessage(null);

        exception = new TorrentDetailsParseException("test message", cause, true, false);
        assertThat(exception).hasMessage("test message");
        assertThat(exception).hasCause(cause);
    }
}