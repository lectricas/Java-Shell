package bntler;

import java.util.List;

public record BashPipeline(BashNode left, BashNode right) implements BashNode{

}
