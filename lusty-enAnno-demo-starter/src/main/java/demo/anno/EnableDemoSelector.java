//package demo.anno;
//
//import demo.config.DemoConfig;
//import org.springframework.context.annotation.AdviceMode;
//import org.springframework.context.annotation.AdviceModeImportSelector;
//import org.springframework.context.annotation.ImportSelector;
//import org.springframework.core.type.AnnotationMetadata;
//import org.springframework.scheduling.annotation.EnableAsync;
//
//public class EnableDemoSelector implements ImportSelector {
//
//    @Override
//    public String[] selectImports(AnnotationMetadata annotationMetadata) {
//        return new String[]{DemoConfig.class.getName()};
//
//    }
//}
