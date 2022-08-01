import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class CommandShould {

    @Test
    void fail_to_initialize_from_null_value() {
        assertThatNullPointerException().isThrownBy(() -> Command.from(null));
    }

    @ParameterizedTest
    @EnumSource(value = CommandType.class)
    void initialize_from_valid_type(CommandType type) {
        var command = Command.from(type);

        assertThat(command.getType()).isEqualTo(type);
    }
}
