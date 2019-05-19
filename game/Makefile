-include rules.mk

INCLUDES =$(foreach INCTREE,$(INCDIR),$(addprefix -I,$(INCTREE)))

$(shell test -d $(BUILDDIR) || mkdir $(BUILDDIR))
$(shell test -d $(BINDIR)  || mkdir $(BINDIR))
$(shell test -d $(OBJSDIR) || mkdir $(OBJSDIR))

OBJS = $(foreach OBJTREE,$(OBJ),$(addprefix $(OBJSDIR)/,$(OBJTREE)))

vpath %.c $(SOURCEDIR)
vpath %.o $(OBJSDIR)

$(OUTPUTNAME):$(OBJ)
	$(CC) $(OBJS) -o $(BINDIR)/$@ $(CFLAGS)
	@echo $(LOG)
%.o:%.c
	$(CC) $(INCLUDES) $(CFLAGS) -c $^ -o $(OBJSDIR)/$@

clean:
	$(RM) $(BUILDDIR)
	$(RM) ./lib

clean_obj:
	$(RM) ./build/obj

.PHONY:clean clean_obj
