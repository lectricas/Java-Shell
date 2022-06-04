package bntler;

import java.util.List;

public record BashCommand (List<String> parts) implements BashNode {
}
