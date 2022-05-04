
@Service
public class FormatServiceFieldInjection
{
    @Autowired
    public FormatUtil formatUtil;

    public void checkFormatted()
    {
        System.out.println(this.formatUtil.formatted(true));
    }
}