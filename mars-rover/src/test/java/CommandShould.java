import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class CommandShould {

    @Test
    void fail_to_initialize_from_null_value() {
        assertThatNullPointerException().isThrownBy(() -> Command.from(null));
    }

    @Test
    void initialize_from_valid_value() {
        var value = "M";
        var command = Command.from(value);

        assertThat(command.getValue()).isEqualTo(value);
    }
}
